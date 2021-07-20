package com.example.springbootmockapi.services.comedian;

import com.example.springbootmockapi.models.Comedian;

import java.util.Collection;

public interface ComedianService {
    public abstract Comedian getAComedian(String id);
    public abstract Comedian createComedian(Comedian comedian);
    public abstract Comedian updateComedian(String id, Comedian comedian);
    public abstract boolean deleteComedian(String id);
    public abstract Collection<Comedian> getComedians();
}
