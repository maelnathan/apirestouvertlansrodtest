package com.cdilansrod.apirestlansrod.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetailVersEntByTCDTO implements Serializable {
    private Long id;
    private String nomEntreprise;
    private BigDecimal salaireMin;
    private BigDecimal salaireMoyen;
    private BigDecimal salaireMax;

    public DetailVersEntByTCDTO() {
        // Empty constructor needed for Jackson.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public BigDecimal getSalaireMin() {
        return salaireMin;
    }

    public void setSalaireMin(BigDecimal salaireMin) {
        this.salaireMin = salaireMin;
    }

    public BigDecimal getSalaireMoyen() {
        return salaireMoyen;
    }

    public void setSalaireMoyen(BigDecimal salaireMoyen) {
        this.salaireMoyen = salaireMoyen;
    }

    public BigDecimal getSalaireMax() {
        return salaireMax;
    }

    public void setSalaireMax(BigDecimal salaireMax) {
        this.salaireMax = salaireMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DetailVersEntByTCDTO)) {
            return false;
        }

        return id != null && id.equals(((DetailVersEntByTCDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DetailVersEntByTCDTO{" +
                "id=" + id +
                ", nomEntreprise='" + nomEntreprise + '\'' +
                ", salaireMin=" + salaireMin +
                ", salaireMoyen=" + salaireMoyen +
                ", salaireMax=" + salaireMax +
                '}';
    }


}
