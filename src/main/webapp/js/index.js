$.post("Servlet", {
        type: "tophot"
    },
    function (data) {
        let list = JSON.parse(data)
        console.log(data);
        //TODO:img title href=""
        $.each(list, function (name, value) {
            let str =
                "                <img src=\"" + value.pic_url + "\">\n" +
                "                <div class=\"carousel-caption\">\n" +
                "                    <h3>" + value.title + "</h3>\n" +
                "                    <p>" + value.content + "</p>\n" +
                "                </div>";

            let div = document.createElement("div");
            if (name === '0') div.setAttribute("class", 'item active');
            else div.setAttribute("class", 'item');
            div.setAttribute("id", "top" + name);
            div.innerHTML = str;
            $(".carousel-inner")[0].appendChild(div);
        });
    });

$.post("Servlet", {
        type: "latestcourse"
    },
    function (data) {
        let list = JSON.parse(data)
        console.log(data);
        //TODO:img title href=""
        $.each(list, function (name, value) {
            let str =
                "<img src=\"" + value.pic_url + "\">\n" +
                "        <h6>" + value.title + "</h6>\n" +
                "        <p>" + value.content + "</p>";

            let div = document.createElement("div");
            div.setAttribute("class", 'col-lg-3');
            div.setAttribute("id", "latest" + name);
            div.innerHTML = str;
            $(".row")[0].appendChild(div);
        });
    });