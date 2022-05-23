package by.grsu.edu.auction.delegators;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.api.LotApiDelegate;
import by.grsu.edu.auction.model.LotDto;

@Service
public class LotApiDelegateImpl implements LotApiDelegate
{
	@Override
	public ResponseEntity<List<LotDto>> findAllLots()
	{
		return ResponseEntity.ok(Collections.emptyList());
	}
}
