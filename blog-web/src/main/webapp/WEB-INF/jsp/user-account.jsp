<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/taglib.jsp" %>
<%--add blog--%>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Add blog
</button>

<form:form commandName="blog" cssClass="form-horizontal blogForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="addBlogLabel">Add new blog</h4>
                </div>
                <div class="modal-body">
                        <%--name--%>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name:</label>

                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                        <%--url--%>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">URL:</label>

                        <div class="col-sm-10">
                            <form:input path="url" cssClass="form-control"/>
                            <form:errors path="url"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save">
                </div>
            </div>
        </div>
    </div>
</form:form>

<br>
<br>


<%--tabs--%>
<script type="text/javascript">
    $(document).ready(function () {
        // Select first tab
        $('.nav-tabs a:first').tab('show');
        //remove blog
        $(".triggerRemove").click(function (e) {
            e.preventDefault();
            $("#modalRemoveBlog .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemoveBlog").modal();
        });
        //jquery validation
        $(".blogForm").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 1
                        },
                        url: {
                            required: true,
                            url: true
                        }
                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    });
</script>

<div role="tabpanel">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <c:forEach items="${user.blogs}" var="blog">
            <li role="presentation"><a href="#blog_${blog.id}" aria-controls="profile" role="tab"
                                       data-toggle="tab">${blog.name}</a></li>
        </c:forEach>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <c:forEach items="${user.blogs}" var="blog">
            <div role="tabpanel" class="tab-pane" id="blog_${blog.id}">

                    <%--blog name and link--%>
                <h1><a href="<spring:url value="${blog.url}" />">${blog.name}</a></h1>

                    <%--remove blog button--%>
                <a href="<spring:url value="/blog/remove/${blog.id}.html" />"
                   class="btn btn-danger triggerRemove">Remove blog</a>

                    <%--blog items--%>
                <table class="table table-bordered table-hover table-striped" id="itemsTable">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>date</th>
                            <th>item</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${blog.items}" var="item" varStatus="rowCounter">
                        <tr>
                            <td align="center">
                                <c:set var="rowNumber" scope="session"
                                       value="${(currentPage - 1) * pageSize + rowCounter.count}"/>
                                <b><c:out value="${rowNumber}"/></b>
                            </td>
                            <td>
                                <fmt:formatDate value="${item.publishedDate}" pattern="dd-MM-yyyy"/>
                                <br/>
                                <b><i><c:out value="${item.blog.name}"/></i></b>
                            </td>
                            <td>
                                <strong>
                                    <a href="<c:out value="${item.link}" />" target="_blank">
                                        <c:out value="${item.title}"/>
                                    </a>
                                </strong>
                                <br/>
                                    ${item.description}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                    <%--end blog items--%>
            </div>
        </c:forEach>
    </div>

</div>

<%--remove action--%>

<!-- Modal remove blog-->
<div class="modal fade" id="modalRemoveBlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="removeBlogLabel">Remove blog</h4>
            </div>
            <div class="modal-body">
                Really want to remove blog?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>
