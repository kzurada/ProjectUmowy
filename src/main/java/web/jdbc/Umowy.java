package web.jdbc;

public class Umowy {

	private String system;
	private Integer request;
	private String order_number;
	private String from_date;
	private String to_date;
	private Double amount;
	private String amount_type;
	private String amount_period;
	private Integer authorization_percent;
	private String active;

	public Umowy(String system, Integer request, String order_number, String from_date, String to_date, Double amount, String amount_type, String amount_period, Integer authorization_percent, String active) {
		this.system = system;
		this.request = request;
		this.order_number = order_number;
		this.from_date = from_date;
		this.to_date = to_date;
		this.amount = amount;
		this.amount_type = amount_type;
		this.amount_period = amount_period;
		this.authorization_percent = authorization_percent;
		this.active = active;
	}

	public Umowy(String system, String order_number, String from_date, String to_date, Double amount, String amount_type, String amount_period, Integer authorization_percent, String active) {
		this.system = system;
		this.order_number = order_number;
		this.from_date = from_date;
		this.to_date = to_date;
		this.amount = amount;
		this.amount_type = amount_type;
		this.amount_period = amount_period;
		this.authorization_percent = authorization_percent;
		this.active = active;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Integer getRequest() {
		return request;
	}

	public void setRequest(Integer request) {
		this.request = request;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAmount_type() {
		return amount_type;
	}

	public void setAmount_type(String amount_type) {
		this.amount_type = amount_type;
	}

	public String getAmount_period() {
		return amount_period;
	}

	public void setAmount_period(String amount_period) {
		this.amount_period = amount_period;
	}

	public Integer getAuthorization_percent() {
		return authorization_percent;
	}

	public void setAuthorization_percent(Integer authorization_percent) {
		this.authorization_percent = authorization_percent;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Umowy{" +
				"system='" + system + '\'' +
				", request=" + request +
				", order_number='" + order_number + '\'' +
				", from_date='" + from_date + '\'' +
				", to_date='" + to_date + '\'' +
				", amount=" + amount +
				", amount_type='" + amount_type + '\'' +
				", amount_period='" + amount_period + '\'' +
				", authorization_percent=" + authorization_percent +
				", active='" + active + '\'' +
				'}';
	}
}
