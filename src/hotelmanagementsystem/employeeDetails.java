package hotelmanagementsystem;

/**
 *
 * @author amhas
 */
public class employeeDetails {
    
    int Id ,age , salary , nid ;
    String fullName , gender , jobType , email ;

    public employeeDetails(int Id, int age, int salary, int nid, String fullName, String gender, String jobType, String email) {
        this.Id = Id;
        this.age = age;
        this.salary = salary;
        this.nid = nid;
        this.fullName = fullName;
        this.gender = gender;
        this.jobType = jobType;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
