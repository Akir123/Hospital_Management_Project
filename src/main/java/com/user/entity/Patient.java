package com.user.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Patient")
public class Patient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="patient_id")
private Long id;
@Column(name="patient_name")
private String name;
@Column(name="patient_phone")
private String phone;
@Column(name="patient_email")
private String email;
@Column(name="patient_disease")
private String disease;


public Patient() {

}
public Patient(Long id, String name, String phone, String email, String disease) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.disease = disease;
}


}
