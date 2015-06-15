package mikrotikApi;


/**
 * This class is container for sendig cmd and respose string 
 * access on field is sync and safe for concurency
 * @author dzirtt
 *
 */
/**
 * @author EXIA
 *
 */
public class SendingItem {
	//request
	private Command cmd;
	//respopnse
	private Responce responce;

	public SendingItem() {

	}

	/**
	 * @param cmd Request string in Command container
	 */
	public void setRequest(Command cmd) {
		synchronized (this.cmd) {
			this.cmd = cmd;
		}

	}

	/**
	 * @return Request string in Command container
	 */
	public Command getRequest() {
		Command tmp;
		synchronized (cmd) {
			tmp = cmd;
		}
		return tmp;
	}

	/**
	 * @param responce responce in Responce container
	 */
	public void setResponse(Responce responce) {
		synchronized (this.responce) {
			this.responce = responce;
		}
	}

	/**
	 * @return respose on request in Respoce container
	 */
	public Responce getResponce() {
		Responce tmp;
		synchronized (responce) {
			tmp = responce;
		}
		return tmp;
	}

	/**
	 * @return Request line as String
	 */
	public String getRequestAsString() {
		return getRequest().toString();
	}

	/**
	 * @return rresponce linie as String
	 */
	public String getResponceAsString() {
		return getResponce().toString();
	}

}
