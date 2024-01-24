
package com.u2team.huansync.establishment.DAO;

import java.util.List;

/**
 *
 * @author misae
 */
public interface IGetAll<T> extends IDao {
    List<T> getAll();
}
