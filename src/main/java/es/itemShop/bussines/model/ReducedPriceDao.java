package es.itemShop.bussines.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reduced_price")
public class ReducedPriceDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_reduced")
	private Long id_reduced;
	@Column(name = "start_date")
	private Date start_date;
	@Column(name = "end_date")
	private Date end_date;
	@Column(name = "reduced_percent")
	private Long reduced_percent;
	//----- GETTERS Y SETTERS -----//
	// ID REDUCED 
	public Long getId_reduced() {
		return id_reduced;
	}
	public void setId_reduced(Long id_reduced) {
		this.id_reduced = id_reduced;
	}
	
	// START DATE
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	// END DATE
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	// REDUCED PRICE
	public Long getReduced_percent() {
		return reduced_percent;
	}
	public void setReduced_percent(Long reduced_price) {
		this.reduced_percent = reduced_price;
	}
	

}