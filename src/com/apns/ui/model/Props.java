package com.apns.ui.model;

public class Props {
	String pnsToken;
	String certPath;
	String message ;
			
	String password  ; 
	boolean isProduction;
	
	/**
	 * @return the pnsToken
	 */
	public String getPnsToken() {
		return pnsToken;
	}
	/**
	 * @param pnsToken the pnsToken to set
	 */
	public void setPnsToken(String pnsToken) {
		this.pnsToken = pnsToken;
	}
	/**
	 * @return the certPath
	 */
	public String getCertPath() {
		return certPath;
	}
	/**
	 * @param certPath the certPath to set
	 */
	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the isProduction
	 */
	public boolean isProduction() {
		return isProduction;
	}
	/**
	 * @param isProduction the isProduction to set
	 */
	public void setProduction(boolean isProduction) {
		this.isProduction = isProduction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Props [pnsToken=" + pnsToken + ", certPath=" + certPath
				+ ", message=" + message + ", password=" + password
				+ ", isProduction=" + isProduction + "]";
	}
	
}
