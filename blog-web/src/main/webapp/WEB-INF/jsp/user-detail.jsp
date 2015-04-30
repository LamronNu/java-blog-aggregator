<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../layout/taglib.jsp" %>

<h1>${user.name}</h1>

<%--tabs--%>
<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show') // Select first tab
        $(".triggerRemove").click(function (e) {
            e.preventDefault();
            $("#modalRemoveBlog .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemoveBlog").modal();
        });
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
                <h1> ${blog.name}</h1>
                <a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">remove
                    blog</a>

                <p> ${blog.url}</p>

                <table class="table table-bordered table-hover table-striped">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Link</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${blog.items}" var="item">
                        <tr>
                            <th>${item.title}</th>
                            <th>${item.link}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
