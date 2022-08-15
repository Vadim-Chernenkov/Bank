package com.example.Bank.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PersonalData {
  @Id
  private String personalNumberOwner;
  private String lastName;
  private String firstName;
  private String middleName;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateofBirthday;
  private boolean citizenOfBelarus;

  public PersonalData() {
  }

  public String getPersonalNumberOwner() {
    return personalNumberOwner;
  }

  public void setPersonalNumberOwner(String personalNumberOwner) {
    this.personalNumberOwner = personalNumberOwner;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Date getDateofBirthday() {
    return dateofBirthday;
  }

  public void setDateofBirthday(Date dateofBirthday) {
    this.dateofBirthday = dateofBirthday;
  }

  public boolean isCitizenOfBelarus() {
    return citizenOfBelarus;
  }

  public void setCitizenOfBelarus(boolean citizenOfBelarus) {
    this.citizenOfBelarus = citizenOfBelarus;
  }

  @Override
  public String toString() {
    return "PersonalData{" +
        "personalNumberOwner='" + personalNumberOwner + '\'' +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", dateofBirthday=" + dateofBirthday +
        ", citizenOfBelarus=" + citizenOfBelarus +
        '}';
  }
}
