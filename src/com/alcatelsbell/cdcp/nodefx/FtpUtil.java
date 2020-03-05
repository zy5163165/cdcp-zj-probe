package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.util.protocol.FtpFunc;
import com.alcatelsbell.nms.util.protocol.SFtpFunc;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-11
 * Time: 下午1:28
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class FtpUtil {

	private static void mkAndCdDir(String path, ChannelSftp channelSftp) throws SftpException {
		String[] split = path.split("/");
		for (int i = 0; i < split.length; i++) {
			String dir = split[i];
			try {
				channelSftp.cd(dir);
			} catch (SftpException e) {
				try {
					channelSftp.mkdir(dir);
					channelSftp.cd(dir);
				} catch (SftpException e1) {
					throw e1;
				}
			}

		}
	}

	public static FtpInfo uploadFile(String domain, String vendor, String city, File file) throws Exception {
		String host = SysProperty.getString("ftpHost");
		String user = SysProperty.getString("ftpUser");
		String password = SysProperty.getString("ftpPassword");
		String ftpRootPath = SysProperty.getString("ftpRootPath", "/");
		String ftpType = SysProperty.getString("ftpType", "FTP");

		if (ftpType.equals("FTP")) {

			FtpFunc ftp = new FtpFunc(host, user, password);
			ftp.connect();
			ftp.createDirecroty(ftpRootPath + "/" + domain + "/" + vendor + "/" + city, ftp.getFtpClient());
			try {
				int port = SysProperty.getInt("ftpPort", 21);
				ftp.uploadFile(ftpRootPath + "/" + domain + "/" + vendor + "/" + city, file.getName(), file.getAbsolutePath());
				FtpInfo ftpInfo = new FtpInfo(user, password, host, port, ftpRootPath + "/" + domain + "/" + vendor + "/" + city, file.getName());
				ftpInfo.setType(FtpInfo.TYPE_FTP);
				return ftpInfo;
			} catch (Exception e) {
				ftp.disconnect();
				throw new Exception("上传文件:" + file.getName() + " 失败", e);
			} finally {
				ftp.disconnect();
			}
		} else if (ftpType.equals("SFTP")) {
			int port = SysProperty.getInt("ftpPort", 22);
			SFtpFunc sFtpFunc = new SFtpFunc();
			ChannelSftp connect = sFtpFunc.connect(host, port, user, password);
			// String dir = ftpRootPath + "/" + domain + "/" + vendor + "/" + city;
			try {
				try {
					connect.cd("/data");
				} catch (Exception e) {
					connect.disconnect();
					throw new Exception(host+"-"+port+"-"+user+"-"+password+"-"+ftpRootPath + " : " + e.getMessage());
				}
				connect.cd(ftpRootPath);
				String dir = domain + "/" + vendor + "/" + city;
				mkAndCdDir(dir, connect);

				sFtpFunc.upload(".", file.getAbsolutePath(), connect);
				FtpInfo ftpInfo = new FtpInfo(user, password, host, port, ftpRootPath + "/" + dir, file.getName());
				ftpInfo.setType(FtpInfo.TYPE_SFTP);
				return ftpInfo;
			} catch (Exception e) {
				connect.disconnect();
				throw new Exception(host+"-"+port+"-"+user+"-"+password+"-"+ftpRootPath + " : " + e.getMessage());
			} finally {
				connect.disconnect();
				if (connect.getSession() != null) {
					try {
						connect.getSession().disconnect();
					} catch (JSchException e) {
						e.printStackTrace();
					}
				}
			}
		}

		throw new Exception("unknown ftp type : " + ftpType);

	}

	public static void main(String[] args) throws Exception {
		uploadFile("PTN", "HW", "HZ", new File("d:\\work\\nohup.rar2"));

	}
}
