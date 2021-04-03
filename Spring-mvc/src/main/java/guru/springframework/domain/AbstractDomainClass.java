package guru.springframework.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class AbstractDomainClass implements DomainObject{

	@Id
	@GeneratedValue
	private Integer id;
	
//	@CreationTimestamp
	private Date dateCreated;
	
//	@UpdateTimestamp
	private Date dateUpdated;
	
	@Version
	private Integer version;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;
		
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        dateUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }

	
}
