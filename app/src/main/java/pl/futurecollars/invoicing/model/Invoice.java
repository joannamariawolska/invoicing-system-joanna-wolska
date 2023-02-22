package pl.futurecollars.invoicing.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Invoice {

  private long id;
  private LocalDateTime date;
  private Company buyer;
  private Company seller;
  private List<InvoiceEntry> entries;

}