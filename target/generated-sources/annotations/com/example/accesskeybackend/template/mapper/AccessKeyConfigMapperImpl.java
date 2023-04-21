package com.example.accesskeybackend.template.mapper;

import com.example.accesskeybackend.template.dto.AccessKeyConfigDto;
import com.example.accesskeybackend.template.entity.AccessKeyConfig;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T12:59:29+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class AccessKeyConfigMapperImpl implements AccessKeyConfigMapper {

    @Override
    public AccessKeyConfig toEntity(AccessKeyConfigDto accessKeyConfigDto) {
        if ( accessKeyConfigDto == null ) {
            return null;
        }

        AccessKeyConfig.AccessKeyConfigBuilder accessKeyConfig = AccessKeyConfig.builder();

        accessKeyConfig.serverTag( accessKeyConfigDto.getServerTag() );
        accessKeyConfig.threadLimit( accessKeyConfigDto.getThreadLimit() );
        accessKeyConfig.maxLinkedIps( accessKeyConfigDto.getMaxLinkedIps() );
        accessKeyConfig.ttl( accessKeyConfigDto.getTtl() );
        accessKeyConfig.authType( accessKeyConfigDto.getAuthType() );
        accessKeyConfig.rotatePeriod( accessKeyConfigDto.getRotatePeriod() );
        List<String> list = accessKeyConfigDto.getAllowedDestinations();
        if ( list != null ) {
            accessKeyConfig.allowedDestinations( new ArrayList<String>( list ) );
        }
        List<String> list1 = accessKeyConfigDto.getDisabledDestinations();
        if ( list1 != null ) {
            accessKeyConfig.disabledDestinations( new ArrayList<String>( list1 ) );
        }

        return accessKeyConfig.build();
    }

    @Override
    public AccessKeyConfigDto toDto(AccessKeyConfig accessKeyConfig) {
        if ( accessKeyConfig == null ) {
            return null;
        }

        AccessKeyConfigDto accessKeyConfigDto = new AccessKeyConfigDto();

        accessKeyConfigDto.setServerTag( accessKeyConfig.getServerTag() );
        accessKeyConfigDto.setThreadLimit( accessKeyConfig.getThreadLimit() );
        accessKeyConfigDto.setMaxLinkedIps( accessKeyConfig.getMaxLinkedIps() );
        accessKeyConfigDto.setTtl( accessKeyConfig.getTtl() );
        accessKeyConfigDto.setAuthType( accessKeyConfig.getAuthType() );
        accessKeyConfigDto.setRotatePeriod( accessKeyConfig.getRotatePeriod() );
        List<String> list = accessKeyConfig.getAllowedDestinations();
        if ( list != null ) {
            accessKeyConfigDto.setAllowedDestinations( new ArrayList<String>( list ) );
        }
        List<String> list1 = accessKeyConfig.getDisabledDestinations();
        if ( list1 != null ) {
            accessKeyConfigDto.setDisabledDestinations( new ArrayList<String>( list1 ) );
        }

        return accessKeyConfigDto;
    }
}
