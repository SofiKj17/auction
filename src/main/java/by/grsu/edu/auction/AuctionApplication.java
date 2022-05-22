package by.grsu.edu.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"by.grsu.edu.auction"})
@EntityScan(basePackages = {"by.grsu.edu.auction.entity"})
//@EnableJpaRepositories(basePackages = {"by.vodmvi.dms.documents.repositories"})
public class AuctionApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(AuctionApplication.class, args);
	}

}
