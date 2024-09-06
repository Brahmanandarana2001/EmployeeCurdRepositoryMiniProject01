package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="EMPNO-SEQ",initialValue=2000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
private Integer empno;
	@NonNull
	@Column(length=20)
private String ename;
	@NonNull
private Double sal;
	@NonNull
	@Column(length=20)
private String job="clerk";
	@NonNull
private Integer deptno;
}
