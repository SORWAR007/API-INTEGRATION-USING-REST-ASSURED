package config;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Usermodel {

        private String email;
        private String password;
        private String name;
        private String phone_number;
        private String nid;
        private String role;


        public Usermodel(String email, String password, String name, String phone_number, String nid, String role)
        {
            this.email=email;
            this.password=password;
            this.name=name;
            this.phone_number=phone_number;
            this.nid=nid;
            this.role=role;

        }

        public Usermodel()
        {

        }



    }




