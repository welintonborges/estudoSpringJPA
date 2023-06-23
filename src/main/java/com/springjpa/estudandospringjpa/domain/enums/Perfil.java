package com.springjpa.estudandospringjpa.domain.enums;

public enum Perfil {
    ADMIN(1, "ROLE_ADMI"),
    CLIENTE(2, "ROLE_CLIENTE");


    private  Integer cod;
    private String descricao;

    private Perfil(Integer cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer id){
        if (id == null)
            return null;

        for (Perfil x: Perfil.values()) {
            if (id.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}
