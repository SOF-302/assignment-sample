package vn.poly.sof302.duongnv21.common.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Staff Entity
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
@Entity
@Table(name = "DUONGNV21_STAFF")
public class Staff {

    /*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/

    /**
     * DUONGNV21_STAFF.ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /**
     * DUONGNV21_STAFF.DEL_FLG
     */
    @Column(name = "DEL_FLG")
    @Enumerated(EnumType.STRING)
    private DelFlg delFlg;

    /**
     * DUONGNV21_STAFF.INS_DATE
     */
    @Column(name = "INS_DATE")
    private Date insDate;

    /**
     * DUONGNV21_STAFF.UPD_DATE
     */
    @Column(name = "UPD_DATE")
    private Date updDate;

    /*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/

    /**
     * Default constructor
     */
    public Staff() {
    }

    /*=====================================================================================================
     *===== GETTER & SETTER                                                                           =====
     *=====================================================================================================*/

    /*=====================================================================================================
     *===== ENUM CLASSES                                                                              =====
     *=====================================================================================================*/

    /**
     * GENDER Enum
     */
    public enum Gender {

        F, M, U;
    }

    /**
     * DEL_FLG Enum
     */
    public enum DelFlg {

        UNDELETED, DELETED;
    }
}
