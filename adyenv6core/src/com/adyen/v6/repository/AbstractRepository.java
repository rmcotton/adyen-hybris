package com.adyen.v6.repository;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.apache.log4j.Logger;

/**
 * Abstract repository
 */
abstract public class AbstractRepository {
    private static final Logger LOG = Logger.getLogger(AbstractRepository.class);
    protected FlexibleSearchService flexibleSearchService;

    public Object getOneOrNull(FlexibleSearchQuery selectOrderQuery) {
        Object result = null;
        try {
            result = flexibleSearchService.searchUnique(selectOrderQuery);
        } catch (ModelNotFoundException e) {
            //Do nothing
        } catch (Exception e) {
            LOG.error(e);
        }
        return result;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
