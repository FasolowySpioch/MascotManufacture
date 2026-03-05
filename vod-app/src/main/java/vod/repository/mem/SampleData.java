package vod.repository.mem;

import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;


class SampleData {
    static List<Company> companies = new ArrayList<>();
    static List<Designer> designers = new ArrayList<>();
    static List<Mascot> mascots = new ArrayList<>();
    static{
        Designer cryoflower = new Designer(1, "Lucy","Xue");
        //https://glitchproductions.store/products/pomni-plush
        //https://glitchproductions.store/products/jax-plush?srsltid=AfmBOoq_HW7RHfL_2q0bo_jbYK4lSv7XvTozjbA74TQG2hHMoOUisWPd

        Designer mansizedmeatbls = new Designer(2,"Matt", "Gaglione");
        //https://glitchproductions.store/products/kinger-plush

        Designer saber = new Designer(3, "Saber", "Murphy");
        //https://www.fangamer.com/collections/plushes/products/deltarune-lancer-plush
        //https://www.fangamer.com/collections/plushes/products/undertale-shop-tem-plush

        Mascot tem = new Mascot(1, "Temmie Plush", "https://www.fangamer.com/cdn/shop/products/product_UT_shoptem_plush_photo2_86483699-836d-46b7-ac07-97d52a47fd3e.png?crop=center&height=1200&v=1691705211&width=1800", saber,  5);
        Mascot lancer = new Mascot(2, "Lancer Plush", "https://www.fangamer.com/cdn/shop/products/product_DR_lancer_plush_photo0.png?crop=center&height=600&v=1608352100&width=900", saber, 5);
        Mascot pomni = new Mascot(3, "Pomni Plush", "https://glitchproductions.store/cdn/shop/files/pomni-plush-2.png?v=1762228046&width=600", cryoflower, 5);
        Mascot kinger = new Mascot(4, "Kinger Plush", "https://glitchproductions.store/cdn/shop/files/kinger-plush-2.png?v=1762228986&width=600", mansizedmeatbls, 5);
        Mascot jax = new Mascot(5, "Jax Plush", "https://glitchproductions.store/cdn/shop/files/jax-plush-1.png?v=1762231391&width=600", cryoflower, 5);

        bind(saber, tem);
        bind(saber, lancer);
        bind(cryoflower, pomni);
        bind(cryoflower, jax);
        bind(mansizedmeatbls, kinger);

        Company glitch = new Company(1, "Glitch Productions", "https://upload.wikimedia.org/wikipedia/en/thumb/6/63/Glitch_Productions_2023.svg/1280px-Glitch_Productions_2023.svg.png");
        Company fangamer = new Company(2, "fangamer", "https://www.fangamer.com/cdn/shop/files/fg-logo-stacked-margins.png?height=500&v=1695396365");

        bind(tem, fangamer);
        bind(lancer, fangamer);
        bind(pomni, glitch);
        bind(jax, glitch);
        bind(kinger, glitch);

        designers.add(cryoflower);
        designers.add(mansizedmeatbls);
        designers.add(saber);

        mascots.add(tem);
        mascots.add(lancer);
        mascots.add(pomni);
        mascots.add(kinger);
        mascots.add(jax);

        companies.add(fangamer);
        companies.add(glitch);
    }
    private static void bind(Designer d, Mascot m){
        m.setDesigner(d);
        d.addMascot(m);
    }

    private static void bind(Mascot m, Company c){
        m.addCompany(c);
        c.addMascot(m);
    }
}
