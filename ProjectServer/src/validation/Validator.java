/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import domain.DomainObject;

/**
 *
 * @author Pocerc
 */
public interface Validator {
    public void validate(DomainObject value) throws Exception;
}
