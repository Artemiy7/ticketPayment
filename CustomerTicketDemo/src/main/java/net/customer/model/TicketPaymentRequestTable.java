package net.customer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
@Getter
@Setter
@ToString
@Entity
@Table(name="ticket_payment_request_table")
public class TicketPaymentRequestTable {

    @JsonManagedReference
    @OneToOne(mappedBy = "ticketPaymentRequestTable", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    IdStatusTable statusTable;

    @Id
    @Column(name = "request_id")
    private Long requestId;

    @JsonProperty("routeNumber")
    @Column(name="route_number")
    private Long routeNumber;

    @JsonProperty("clientId")
    @Column(name = "client_id", updatable=false, nullable=false)
    private Long clientId;

    @JsonProperty("date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull
    @Column(name = "request_date", updatable=false, nullable=false)
    private Date date;

}
