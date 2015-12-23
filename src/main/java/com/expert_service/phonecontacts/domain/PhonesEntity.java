package com.expert_service.phonecontacts.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Класс-сущность для отображения таблицы "Телефоны"
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Entity
@Table(name = "phones", schema = "contacts")
@NamedQueries({@NamedQuery(name = "Phones.PhonesList",
                query = "from PhonesEntity ph"),
})
public class PhonesEntity {
    private String idPhone;
    private String idClient;
    private String phoneNumber;
    private String phoneType;
    private String comment;
    /** client - ссылка на сущность {@link ClientsEntity ClientsEntity}, для реализации связи один-к-одному*/
    private ClientsEntity client;

    @Id
    @Column(name = "id_phone", nullable = false, length = 6)
    public String getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(String idPhone) {
        this.idPhone = idPhone;
    }

    @Basic
    @Column(name = "id_client", nullable = false, length = 10)
    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "phone_type", nullable = true, length = 15)
    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 50)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhonesEntity that = (PhonesEntity) o;

        if (idPhone != null ? !idPhone.equals(that.idPhone) : that.idPhone != null) return false;
        if (idClient != null ? !idClient.equals(that.idClient) : that.idClient != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (phoneType != null ? !phoneType.equals(that.phoneType) : that.phoneType != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPhone != null ? idPhone.hashCode() : 0;
        result = 31 * result + (idClient != null ? idClient.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (phoneType != null ? phoneType.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", insertable = false, updatable = false, nullable = false)
    public ClientsEntity getClient() {
        return client;
    }

    public void setClient(ClientsEntity client) {
        this.client = client;
    }
}
