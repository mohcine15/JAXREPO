package com.example.JaxTP.Config;

import com.example.JaxTP.Entity.Compte;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import com.example.JaxTP.Entity.Compte;

import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class CompteListMessageBodyWriter implements MessageBodyWriter<List<Compte>> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return List.class.isAssignableFrom(type) && mediaType.isCompatible(MediaType.APPLICATION_XML_TYPE);
    }

    @Override
    public void writeTo(List<Compte> comptes, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        jakarta.ws.rs.core.MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws java.io.IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(Compte.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(comptes, entityStream);
        } catch (Exception e) {
            throw new java.io.IOException(e);
        }
    }
}
