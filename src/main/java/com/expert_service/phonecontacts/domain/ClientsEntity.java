package com.expert_service.phonecontacts.domain;

import javax.persistence.*;

/**
 * Класс-сущность для отображения таблицы "Клиенты"
 * @version 1.0.0
 * @author Донченко Руслан
 */
@Entity
@Table(name = "clients", schema = "contacts")
@NamedQueries({
        @NamedQuery(name = "Clients.ClientsWithPhones",
                query = "select cl from ClientsEntity cl left join fetch cl.phone p"),
        @NamedQuery(name = "Clients.ClientsList",
                query = "from ClientsEntity cl"),
})
public class ClientsEntity {
    private String idClient;
    private String clientFio;
    /** phone - ссылка на сущность {@link PhonesEntity PhoneEntity}, таким образом реализовывается связь один-к-одному*/
    private PhonesEntity phone;

    @Id
    @Column(name = "id_client", nullable = false, length = 10)
    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "client_fio", nullable = false, length = 50)
    public String getClientFio() {
        return clientFio;
    }

    public void setClientFio(String clientFio) {
        this.clientFio = clientFio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (idClient != null ? !idClient.equals(that.idClient) : that.idClient != null) return false;
        if (clientFio != null ? !clientFio.equals(that.clientFio) : that.clientFio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient != null ? idClient.hashCode() : 0;
        result = 31 * result + (clientFio != null ? clientFio.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public PhonesEntity getPhone() {
        return phone;
    }

    public void setPhone(PhonesEntity phone) {
        this.phone = phone;
    }
}
