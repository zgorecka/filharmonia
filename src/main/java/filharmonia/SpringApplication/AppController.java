package filharmonia.SpringApplication;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/koncerty").setViewName("koncerty");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/edit_dane").setViewName("user/edit_dane");
        registry.addViewController("/edit_adres").setViewName("user/edit_adres");
        registry.addViewController("/bilety").setViewName("user/bilety");
    }



    @Autowired
    private KoncertDAO daoKoncert;

    @RequestMapping("/koncerty")
    public String viewKoncertyPage(Model model){
        List<Koncert> listKoncert = daoKoncert.list();
        model.addAttribute("listKoncert", listKoncert);

        return "koncerty";
    }

    @Autowired
    private KlientDAO daoKlient;

    @Autowired
    private AdresDAO daoAdres;

    @RequestMapping("/main_user")
    public String viewUserPage(Model model){
        Klient klient = daoKlient.get(1);
        model.addAttribute("klient", klient);
        Adres adres = daoAdres.get(klient.getId_adres());
        model.addAttribute("adres", adres);

        return "user/main_user";
    }

    @Autowired
    private PracownikDAO daoPracownik;

    @RequestMapping("/main_admin")
    public String showAdminPage(Model model){
        List<Pracownik> listPracownik = daoPracownik.lsit();
        System.out.println("lista z app con show admin page");
        System.out.println(listPracownik);

        for(Pracownik pracownik : listPracownik){
            Adres adres = daoAdres.get(pracownik.getId_adres());
            pracownik.setKraj(adres.getKraj());
            pracownik.setMiasto(adres.getMiasto());
            pracownik.setUlica(adres.getUlica());
            pracownik.setNumer_budynku(adres.getNumer_budynku());
            pracownik.setNumer_lokalu(adres.getNumer_lokalu());
            pracownik.setId_poczty(adres.getId_poczty());
            System.out.println("app controller showAdminpage");
            System.out.println(pracownik);
        }


        model.addAttribute("listPracownik", listPracownik);

        Pracownik pracownik_save = new Pracownik();
        model.addAttribute("pracownik_save", pracownik_save);

        return "admin/main_admin";
    }
/*
    @RequestMapping("/edit_dane")
    public String viewEditPage(Model model){
        Klient klient = daoKlient.get(1);
        model.addAttribute("klient", klient);
        Adres adres = daoAdres.get(klient.getId_adres());
        model.addAttribute("adres", adres);

        return "user/edit_dane";
    }

 */

    @RequestMapping("/edit_dane/{id_klienta}")
    public ModelAndView showEditForm(@PathVariable(name = "id_klienta") int id_klienta){
        ModelAndView mav = new ModelAndView("/user/edit_dane");
        Klient klient = daoKlient.get(id_klienta);
        mav.addObject("klient", klient);
        Adres adres = daoAdres.get(klient.getId_adres());
        mav.addObject("adres", adres);

        System.out.println("model and view" + klient);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("klient") Klient klient){
        daoKlient.update(klient);
        System.out.println(klient);

        return "redirect:/main_user";
    }
/*
    @RequestMapping("/edit_adres")
    public String viewEditAdresPage(Model model){
        Adres adres = daoAdres.get(1);
        model.addAttribute("klient", klient);
        Adres adres = daoAdres.get(klient.getId_adres());
        model.addAttribute("adres", adres);

        return "user/edit_dane";
    }

 */

    @RequestMapping("/edit_adres/{id_klienta}/{id_adres}")
    public ModelAndView showEditAdresForm(@PathVariable(name = "id_klienta") int id_klienta, @PathVariable(name = "id_adres") int id_adres){
        ModelAndView mav = new ModelAndView("/user/edit_adres");
        Adres adres = daoAdres.get(id_adres);
        Klient klient = daoKlient.get(id_klienta);
        mav.addObject("adres", adres);
        mav.addObject("klient", klient);

        System.out.println("model and view" + klient);

        return mav;
    }

    @RequestMapping(value = "/update_adres", method = RequestMethod.POST)
    public String updateAdres(@ModelAttribute("adres") Adres adres){
        daoAdres.update(adres);
        System.out.println(adres);

        return "redirect:/main_user";
    }

    @Autowired
    BiletDAO daoBilet;

    @RequestMapping("/bilety/{id_klienta}")
    public ModelAndView showBiletyPage(@PathVariable(name = "id_klienta") int id_klienta){
        ModelAndView mav = new ModelAndView("/user/bilety");
        List<Bilet> listBilet = daoBilet.list(id_klienta);
        mav.addObject("listBilet", listBilet);

        return mav;
    }

    @RequestMapping("/{id_klienta}/delete/{id_biletu}")
    public String delete(@PathVariable(name = "id_biletu") int id_biletu){
        daoBilet.delete(id_biletu);

        return "redirect:/bilety/{id_klienta}";
    }

    @RequestMapping("/delete_pracownik/{id_pracownika}")
    public String deletePracownik(@PathVariable(name = "id_pracownika") int id_pracownika){
        daoPracownik.delete(id_pracownika);

        return "redirect:/main_admin";
    }

    @RequestMapping(value = "/update_pracownik", method = RequestMethod.POST)
    public String updatePracownik(@ModelAttribute("pracownik") Pracownik pracownik){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MMM/yy");
        formatter = formatter.withLocale(Locale.UK);

        LocalDate date_uro = LocalDate.parse(pracownik.getData_urodzenia(), formatter);
        LocalDate date_zat = LocalDate.parse(pracownik.getData_zatrudnienia(), formatter);


        pracownik.setData_urodzenia(date_uro.format(formatter2));
        pracownik.setData_zatrudnienia(date_zat.format(formatter2));

        if(pracownik.getData_zwolnienia() == ""){
            pracownik.setData_zwolnienia("");
        }else {
            LocalDate date_zw = LocalDate.parse(pracownik.getData_zwolnienia(), formatter);
            pracownik.setData_zwolnienia(date_zw.format(formatter2));
        }

        Adres adres = new Adres();
        adres.setId_adres(pracownik.getId_adres());
        adres.setKraj(pracownik.getKraj());
        adres.setMiasto(pracownik.getMiasto());
        adres.setUlica(pracownik.getUlica());
        adres.setNumer_budynku(pracownik.getNumer_budynku());
        adres.setNumer_lokalu(pracownik.getNumer_lokalu());

        System.out.println("z app con update pracownik");
        System.out.println(pracownik);

        daoPracownik.update(pracownik);
        daoAdres.update(adres);


        return "redirect:/main_admin";
    }

    @RequestMapping(value = "/save_pracownik", method = RequestMethod.POST)
    public String savePracownik(@ModelAttribute("pracownik") Pracownik pracownik){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MMM/yy");
        formatter = formatter.withLocale(Locale.UK);

        LocalDate date_uro = LocalDate.parse(pracownik.getData_urodzenia(), formatter);
        LocalDate date_zat = LocalDate.parse(pracownik.getData_zatrudnienia(), formatter);


        pracownik.setData_urodzenia(date_uro.format(formatter2));
        pracownik.setData_zatrudnienia(date_zat.format(formatter2));

        if(pracownik.getData_zwolnienia() == null){
            pracownik.setData_zwolnienia(null);
        }else if(pracownik.getData_zwolnienia() == ""){
            pracownik.setData_zwolnienia("");
        }else {
            LocalDate date_zw = LocalDate.parse(pracownik.getData_zwolnienia(), formatter);
            pracownik.setData_zwolnienia(date_zw.format(formatter2));
        }

        daoPracownik.savePracownikAdres(pracownik);

        return "redirect:/main_admin";
    }

    @RequestMapping("/kup_bilet/{id_koncertu}")
    public String kupBilet(@PathVariable(name = "id_koncertu") int id_koncertu){
        Bilet bilet = new Bilet();

        Koncert koncert = daoKoncert.get(id_koncertu);

        bilet.setId_koncertu(id_koncertu);
        bilet.setCena(koncert.getCena());
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy");
        String formattedString = date.format(formatter);
        bilet.setData_zakupu(formattedString);
        bilet.setId_klienta(1);

        daoBilet.save(bilet);

        return "redirect:/koncerty";
    }


    @Controller
    public class DashboardController
    {
        @RequestMapping("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }
/*
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

 */
}