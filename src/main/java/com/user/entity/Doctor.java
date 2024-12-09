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
@Table(name = "Doctor")
public class Doctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="dctor_id")
private Long id;
@Column(name="doctor_name")
private String name;
@Column(name="doctor_specialization")
private String specialization;
@Column(name="doctor_phone")
private String phone;
@Column(name="doctor_email")
private String email;
//
//@OneToOne
//@JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
//private Patient patient;

public Doctor() {

}
public Doctor(Long id, String name, String specialization, String phone, String email) {
	super();
	this.id = id;
	this.name = name;
	this.specialization = specialization;
	this.phone = phone;
	this.email = email;
}


}
