<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/taglib.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {

        $(".triggerRemove").click(function (e) {
            e.preventDefault();
            $("#modalRemoveUser .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemoveUser").modal();
        });
    });
</script>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>user name</th>
        <th>operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href='<spring:url value="/users/${user.id}.html" />'>
                    <c:out value="${user.name}"/>
                </a>
            </td>
            <td>
                <a href='<spring:url value="/users/remove/${user.id}.html" />' class="btn btn-danger triggerRemove">
                    delete
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal remove user-->
<div class="modal fade" id="modalRemoveUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="removeUserLabel">Remove user</h4>
            </div>
            <div class="modal-body">
                Really want to remove user?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>