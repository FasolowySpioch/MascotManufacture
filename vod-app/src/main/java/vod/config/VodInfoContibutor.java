package vod.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.service.MascotService;

@Component
@RequiredArgsConstructor
public class VodInfoContibutor implements InfoContributor {
    private final MascotService mascotService;

    @Override
    public void contribute(Info.Builder builder){
        builder.withDetail("mascots", mascotService.getAllMascots().size());
    }
}
