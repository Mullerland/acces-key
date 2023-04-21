package com.example.accesskeybackend.template.mapper;

import com.example.accesskeybackend.template.dto.AccessKeyConfigDto;
import com.example.accesskeybackend.template.dto.AccessKeyTemplateDto;
import com.example.accesskeybackend.template.entity.AccessKeyTemplate;
import com.example.accesskeybackend.template.entity.ActivatedAccessKey;
import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T22:09:19+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class AccessKeyTemplateMapperImpl implements AccessKeyTemplateMapper {

    @Autowired
    private AccessKeyConfigMapper accessKeyConfigMapper;

    @Override
    public AccessKeyTemplate toEntity(AccessKeyTemplateDto accessKeyTemplateDto) {
        if ( accessKeyTemplateDto == null ) {
            return null;
        }

        AccessKeyTemplate.AccessKeyTemplateBuilder accessKeyTemplate = AccessKeyTemplate.builder();

        accessKeyTemplate.id( accessKeyTemplateDto.getId() );
        accessKeyTemplate.createdAt( accessKeyTemplateDto.getCreatedAt() );
        accessKeyTemplate.accessKeyConfig( accessKeyConfigMapper.toEntity( accessKeyTemplateDto.getAccessKeyConfig() ) );
        accessKeyTemplate.activatedAccessKey( activatedAccessKeyDtoToActivatedAccessKey( accessKeyTemplateDto.getActivatedAccessKey() ) );

        return accessKeyTemplate.build();
    }

    @Override
    public AccessKeyTemplateDto toDto(AccessKeyTemplate template) {
        if ( template == null ) {
            return null;
        }

        UUID id = null;
        Instant createdAt = null;
        AccessKeyConfigDto accessKeyConfig = null;
        AccessKeyTemplateDto.ActivatedAccessKeyDto activatedAccessKey = null;

        id = template.getId();
        createdAt = template.getCreatedAt();
        accessKeyConfig = accessKeyConfigMapper.toDto( template.getAccessKeyConfig() );
        activatedAccessKey = activatedAccessKeyToActivatedAccessKeyDto( template.getActivatedAccessKey() );

        String base64Id = com.example.accesskeybackend.template.Base64Util.toBase64(template.getId().toString());

        AccessKeyTemplateDto accessKeyTemplateDto = new AccessKeyTemplateDto( id, base64Id, createdAt, accessKeyConfig, activatedAccessKey );

        return accessKeyTemplateDto;
    }

    protected ActivatedAccessKey activatedAccessKeyDtoToActivatedAccessKey(AccessKeyTemplateDto.ActivatedAccessKeyDto activatedAccessKeyDto) {
        if ( activatedAccessKeyDto == null ) {
            return null;
        }

        ActivatedAccessKey.ActivatedAccessKeyBuilder activatedAccessKey = ActivatedAccessKey.builder();

        activatedAccessKey.createdAt( activatedAccessKeyDto.getCreatedAt() );
        activatedAccessKey.accessKeyUuid( activatedAccessKeyDto.getAccessKeyUuid() );

        return activatedAccessKey.build();
    }

    protected AccessKeyTemplateDto.ActivatedAccessKeyDto activatedAccessKeyToActivatedAccessKeyDto(ActivatedAccessKey activatedAccessKey) {
        if ( activatedAccessKey == null ) {
            return null;
        }

        Instant createdAt = null;
        String accessKeyUuid = null;

        createdAt = activatedAccessKey.getCreatedAt();
        accessKeyUuid = activatedAccessKey.getAccessKeyUuid();

        AccessKeyTemplateDto.ActivatedAccessKeyDto activatedAccessKeyDto = new AccessKeyTemplateDto.ActivatedAccessKeyDto( createdAt, accessKeyUuid );

        return activatedAccessKeyDto;
    }
}
