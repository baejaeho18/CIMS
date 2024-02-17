function openTab(evt, tabName) {
    var i, tabcontent, tablinks;

    // 모든 탭 내용을 숨깁니다.
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // 탭 버튼의 활성 상태를 제거합니다.
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // 클릭한 탭의 내용을 보이도록 설정하고 해당 버튼을 활성 상태로 표시합니다.
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

// 페이지가 로드될 때 기본 탭을 설정합니다.
document.getElementById("defaultOpen").click();
