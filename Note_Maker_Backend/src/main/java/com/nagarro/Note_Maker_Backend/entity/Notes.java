package com.nagarro.Note_Maker_Backend.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import lombok.Data;

 

@Data
@Entity
@Table(name = "notes")
public class Notes{

	    @Id                             // Telling Hibernate that "id" property is the primary key
	    @GeneratedValue(strategy = GenerationType.AUTO)     // Telling Hibernate that "id" is gonna be auto generated by our database
	    private int id;

	    private String title;
	    
	    @Column(nullable = false, length = 500)
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private User user;
	    
	    @Column(nullable = false)
	    private LocalDateTime createdDt = LocalDateTime.now();

//	    @Column(nullable = false)
//	    private LocalDateTime lastChanged;


    public Notes() {
        // Default constructor
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getter and Setter methods



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public User getUser() {
			return user;
		}

		public LocalDateTime getCreatedDt() {
			return createdDt;
		}

	 

		public void setCreatedDt(LocalDateTime createdDt) {
			this.createdDt = createdDt;
		}
		


}