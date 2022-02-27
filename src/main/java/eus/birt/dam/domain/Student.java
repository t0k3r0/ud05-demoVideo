package eus.birt.dam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student extends BaseEntity {

  @Column(name = "first_name") private String firstName;

  @Column(name = "last_name") private String lastName;

  @Column private String email;

  @ManyToOne @JoinColumn(name = "university_id") private University university;

  public Student(String firstName, String lastName, String email) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
