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
 * Department entity
 * 
 * @author duongnguyen
 * @since 1.0.0
 */
@Entity
@Table(name = "DUONGNV21_DEPARTMENT")
public class Department {

    /*=====================================================================================================
     *===== PRIVATE PROPERTIES                                                                        =====
     *=====================================================================================================*/

    /**
     * DUONGNV21_DEPARTMENT.ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * DUONGNV21_DEPARTMENT.CODE
     */
    @Column(name = "CODE")
    private String code;

    /**
     * DUONGNV21_DEPARTMENT.NAME
     */
    @Column(name = "NAME")
    private String name;

    /**
     * DUONGNV21_DEPARTMENT.DEL_FLG
     */
    @Column(name = "DEL_FLG")
    @Enumerated(EnumType.STRING)
    private DelFlg delFlg;

    /**
     * DUONGNV21_DEPARTMENT.INS_DATE
     */
    @Column(name = "INS_DATE")
    private Date insDate;

    /**
     * DUONGNV21_DEPARTMENT.UPD_DATE
     */
    @Column(name = "UPD_DATE")
    private Date updDate;

    /*=====================================================================================================
     *===== CONSTRUCTOR METHOD                                                                        =====
     *=====================================================================================================*/

    /**
     * Default constructor
     */
    public Department() {
    }

    /*=====================================================================================================
     *===== GETTER & SETTER                                                                           =====
     *=====================================================================================================*/

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the delFlg
     */
    public DelFlg getDelFlg() {
        return delFlg;
    }

    /**
     * @param delFlg the delFlg to set
     */
    public void setDelFlg(DelFlg delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * @return the insDate
     */
    public Date getInsDate() {
        return insDate;
    }

    /**
     * @param insDate the insDate to set
     */
    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    /**
     * @return the updDate
     */
    public Date getUpdDate() {
        return updDate;
    }

    /**
     * @param updDate the updDate to set
     */
    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    /*=====================================================================================================
     *===== ENUM CLASSES                                                                              =====
     *=====================================================================================================*/

    /**
     * DEL_FLG Enum
     */
    public enum DelFlg {

        UNDELETED, DELETED;
    }
}
