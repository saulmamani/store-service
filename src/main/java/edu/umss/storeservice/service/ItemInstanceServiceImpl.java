/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemInstanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemInstanceServiceImpl extends GenericServiceImpl<ItemInstance> implements ItemInstanceService {
    private final ItemInstanceRepository repository;

    public ItemInstanceServiceImpl(ItemInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ItemInstance> getRepository() {
        return repository;
    }

    @Override
    public List<ItemInstance> findByFeature(boolean opc) {
        return repository.findByFeature(opc);
    }

    //sobre escribiendo el metodo save para controlar un solo feature activo
    @Override
    public ItemInstance save(ItemInstance model) {
        //cambiando todos los registros a Featured = false
        if(model.getFeatured() == true) {
            repository.updateFeature();
            return super.save(model);
        }
        else{
            return super.save(model);
        }
    }
}

