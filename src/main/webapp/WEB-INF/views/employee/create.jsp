<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
$(document).ready( function() {
    $(document).on('change', '.btn-file :file', function() {
    var input = $(this),
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [label]);
    });

    $('.btn-file :file').on('fileselect', function(event, label) {
        
        var input = $(this).parents('.input-group').find(':text'),
            log = label;
        
        if( input.length ) {
            input.val(log);
        } else {
            if( log ) alert(log);
        }
    
    });
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#img-upload').attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgInp").change(function(){
        readURL(this);
    });
});
</script>
<style type="text/css">
.btn-file {
    position: relative;
    overflow: hidden;
}
.btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 100px;
    text-align: right;
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    cursor: inherit;
    display: block;
}

#img-upload{
    width: 100%;
}
</style>
</head>
<body>
    <%@include file="/WEB-INF/views/common/navigator.jsp"%>
    <div class="form-group">&nbsp;</div>

    <div class="container">

        <h1>Employee <small>Create screen</small></h1>
        <div class="form-group">&nbsp;</div>

        <!-- BEGIN CREATE FORM -->
        <div>
            <spring:url value="/employee/create" var="formAction"></spring:url>
            <form:form action="${formAction}" method="POST" modelAttribute="employeeCreateForm" enctype="multipart/form-data">

            <div class="row">
                <div class="col">

                    <div class="form-group">
                        <label for="departmentId"><strong>Department: </strong></label>
                        <form:select path="departmentId" cssClass="form-control" cssErrorClass="form-control is-invalid">
                            <form:option value="">--- Please select department ---</form:option>
                            <form:options items="${departments}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <div class="invalid-feedback"><form:errors path="departmentId"/></div>
                    </div>

                    <div class="form-group">
                        <label for="code"><strong>Code: </strong></label>
                        <form:input path="code" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="code"/></div>
                    </div>

                    <div class="form-group">
                        <label for="name"><strong>Name: </strong></label>
                        <form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="name"/></div>
                    </div>

                    <div class="form-group">
                        <label for="name"><strong>Gender: </strong></label>
                        <div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="gender" id="genderMale" value="M" cssStyle="form-check-input" cssErrorClass="form-check-input is-invalid"/>
                                &nbsp;<label class="form-check-label" for="genderMale">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="gender" id="genderFemale" value="F" cssStyle="form-check-input" cssErrorClass="form-check-input is-invalid"/>
                                &nbsp;<label class="form-check-label" for="genderFemale">Female</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="gender" id="genderUnknow" value="U" cssStyle="form-check-input" cssErrorClass="form-check-input is-invalid"/>
                                &nbsp;<label class="form-check-label" for="genderUnknow">Unknow</label>
                            </div>
                        </div>
                        <div class="invalid-feedback"><form:errors path="gender"/></div>
                    </div>

                    <div class="form-group">
                        <label for="birthday"><strong>Birthday: </strong></label>
                        <form:input path="birthday" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="birthday"/></div>
                    </div>

                    <div class="form-group">
                        <label for="email"><strong>Email: </strong></label>
                        <form:input path="email" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="email"/></div>
                    </div>

                    <div class="form-group">
                        <label for="phone"><strong>Phone: </strong></label>
                        <form:input path="phone" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="phone"/></div>
                    </div>

                    <div class="form-group">
                        <label for="salary"><strong>Salary: </strong></label>
                        <form:input path="salary" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="salary"/></div>
                    </div>

                </div>
                <div class="col">
                    <div class="form-group">
                        <label>Upload Image</label>
                        <div class="input-group">
                            <span class="btn btn-secondary btn-file"> Browse… <input type="file" name="file" id="imgInp"></span>
                            <form:input path="photo" cssClass="form-control" cssErrorClass="form-control is-invalid" readonly="true"/>
                        </div>
                        <img id='img-upload' />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col">
                    <label for="notes"><strong>Notes: </strong></label>
                    <form:textarea path="notes" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                    <div class="invalid-feedback"><form:errors path="notes"/></div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col">
                    <button type="submit" class="btn btn-success"><i class="far fa-save"></i> Submit</button>
                    <a href="<spring:url value="/employee"/>" class="btn btn-warning"><i class="fas fa-angle-left"></i> Back</a>
                </div>
            </div>

            </form:form>
        </div>
        <!-- END CREATE FORM -->

    </div>
</body>
</html>