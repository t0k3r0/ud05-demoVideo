package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University extends BaseEntity {

  @Column private String name;

  @OneToMany
  @JoinColumn(name = "university_id")
  List<Student> students = new ArrayList<>();

  public University(String name) {
    super();
    this.name = name;
  }
}
