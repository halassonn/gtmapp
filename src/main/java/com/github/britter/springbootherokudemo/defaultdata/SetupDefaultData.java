package com.github.britter.springbootherokudemo.defaultdata;


import com.github.britter.springbootherokudemo.model.DataKantor;
import com.github.britter.springbootherokudemo.model.UserDetails;
import com.github.britter.springbootherokudemo.model.security.Authority;
import com.github.britter.springbootherokudemo.model.security.User;
import com.github.britter.springbootherokudemo.repo_mod.AuthorityRepo;
import com.github.britter.springbootherokudemo.repo_mod.DataKantor_repo;
import com.github.britter.springbootherokudemo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

@Component
@Transactional
public class SetupDefaultData implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;
    @Autowired
    AuthorityRepo authorityRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DataKantor_repo dataKantorRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) {
            return;
        }

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_USER");

        createDataKantorIfNotFound("585","PT BPR DIORI GANDA","Jalan Besar Simp Kawat","22175",new Date(),null);
        if(userRepository.findByAuthorities_Name("ROLE_ADMIN")==null){
            User user=new User();
            UserDetails userDetails=new UserDetails();

            DataKantor dataKantor=dataKantorRepo.findByNamakantor("PT BPR DIORI GANDA");
            userDetails.setDataKantor(dataKantor);
            userDetails.setEmail("gtm24halas@gmail.com");
            userDetails.setFirstname("Admin");
            userDetails.setLastname("Admin");
            userDetails.setJabatan("Administrasi");
            userDetails.setNik("12311111");
            userDetails.setTglcreate(new Date());
            userDetails.setTglupdate(new Date());

            user.setUsername("Administrator");
            user.setPassword(getPasswordEncoder().encode("Administrator"));
            user.setAuthorities(Arrays.asList(authorityRepo.findByName("ROLE_ADMIN")));
            user.setUserDetails(userDetails);
            user.setEnabled(true);

            userRepository.save(user);

        }


        alreadySetup = true;
    }


    private final Authority createRoleIfNotFound(String name) {
        Authority authority = authorityRepo.findByName(name);
        if (authority == null) {
            authority = new Authority(name);

            authorityRepo.save(authority);
        }
        return authority;
    }
    private final DataKantor createDataKantorIfNotFound(String idkantor, String namakantor, String alamat, String kodepos,Date createat,Date updateat) {
        DataKantor dataKantor=dataKantorRepo.findByNamakantor(idkantor);

        if (dataKantor == null) {
            dataKantor = new DataKantor(idkantor,namakantor,alamat,kodepos,createat,updateat);

            dataKantorRepo.save(dataKantor);
        }
        return dataKantor;
    }



    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
