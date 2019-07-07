/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.ItemInstance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemInstanceRepository extends GenericRepository<ItemInstance>{
    @Query(value = "SELECT * FROM ITEM_INSTANCE WHERE FEATURED = :opc", nativeQuery = true)
    List<ItemInstance> findByFeature(@Param("opc") boolean opc);

    @Query(value = "update ITEM_INSTANCE set FEATURED=0 where FEATURED=1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateFeature();
}
  