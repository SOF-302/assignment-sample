/*
 * ================================================================================
 *   == COPYRIGHT HYPERTECH ENTERPRISE SOLUTIONS. ALL RIGHT RESERVED.            ==
 *   == HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.   ==
 *   ==                                                                          ==
 *   == VISIT HTTP://HYPERTECH.COM.VN FOR MORE INFORMATION                       ==
 * ================================================================================
 *
 *  == Project: iam-api
 *  == Created by: duongnguyen
 *  == Created at: 12/10/17 10:49 PM
 */
package vn.poly.sof302.duongnv21.common.bases;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;


/**
 * io.cobrafw.iam.common.abstracts -> BaseService
 *
 * @author duongnguyen
 * @since 1.0.0
 */
@Transactional
public abstract class BaseService implements BaseServiceInterface {

    /*=====================================================================================================
     *===== PROTECTED PROPERTIES                                                                      =====
     *=====================================================================================================*/

    /** Logger */
    protected final Logger logger = Logger.getLogger(this.getClass());

    /*=====================================================================================================
     *===== PROTECTED METHOD                                                                          =====
     *=====================================================================================================*/


    /*=====================================================================================================
     *===== PUBLIC METHOD                                                                             =====
     *=====================================================================================================*/

}
