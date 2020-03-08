
package io.VideoClub.Model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class Client implements IClient, Comparable<Client> {
private String iD;
private String name;
private String phone;
private LocalDateTime time;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.iD = GenerateId();
        this.time=LocalDateTime.now();
    }

    public Client(String iD, String name, String phone, LocalDateTime time) {
        this.iD = iD;
        this.name = name;
        this.phone = phone;
        this.time = time;
    }

    private Client() {
    }
    
public String GenerateId(){
    String idResult=(String) UUID.randomUUID().toString().subSequence(0, 16);
    return idResult;
}
    @Override
    public String getID() {
       return this.iD;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String n) {
       this.name=n;
    }

    @Override
    public LocalDateTime getTime() {
      return  this.time;
    }

    @Override
    public void setTime(LocalDateTime t) {
     this.time=t;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public void setPhone(String p) {
       this.phone=p;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.iD, other.iD)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int compareTo(Client o) {
       return this.getID().compareTo(o.getID());
    }

    @Override
    public String toString() {
        return "iD=" +   iD + " name=" +   name + " phone=" +   phone + " fecha de nacimiento=" +   time.getYear() + "/" + time.getMonthValue()+ "/" + time.getDayOfMonth();
    }
    
}
