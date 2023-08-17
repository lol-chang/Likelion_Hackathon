const questions = [
    {
      question: "다음 중 주민등록등본, 가족관계증명서등을 출력 할 수 있는 사이트는 무엇일까요?",
      imageUrl: "",
      options: ["정부24", "네이버", "멋쟁이사자처럼"],
      correctOption: 0
    },
    {
      question: "다음 중 민원을 신청할 수 있는 사이트는 어디인가요?",
      imageUrl: "",
      options: ["다음", "맥도날드", "국민신문고"],
      correctOption: 2
    },
    {
        question: "현재 시행하고 있는 공공 정책지원들을 검색하려면 네이버에 뭐라고 검색을 해야 할까요?",
        imageUrl: "",
        options: ["서비스", "공공서비스", "공공보건포털"],
        correctOption: 1
      },
      {
        question: "다음중 네이버 공공서비스 정책지원에서 골라 볼수 있는 목록이 아닌것은 무엇일까요?",
        imageUrl: "",
        options: ["소관기관", "분야별", "성별"],
        correctOption: 2
      },
      {
        question: "네이버 길찾기에서 자세한 경로를 확인하려면 눌러야 하는 버튼은 무엇일까요?",
        imageUrl: "",
        options: ["다시입력", "상세보기", "다시입력"],
        correctOption: 1
      },
      {
        question: "다음화면에서 주민등록등본을 출력하려면 눌러야하는 곳은 어디일까요?",
        imageUrl: "images/q6.jpg",
        options: ["1번", "2번", "3번"],
        correctOption: 0
      },
 
    // 추가 문제들...
  ];
  
  let currentQuestionIndex = 0;
  
  function changeImage(imageUrl) {
    const imageElement = document.getElementById("question-image");
    imageElement.src = imageUrl;
  }
  
  function showQuestion(index) {
    const questionElement = document.getElementById("question");
    const optionsContainer = document.getElementById("options");
    const imageContainer = document.getElementById("image-container");
    
    questionElement.textContent = questions[index].question;
    optionsContainer.innerHTML = "";
  
    questions[index].options.forEach((option, idx) => {
      const button = document.createElement("button");
      button.className = "option";
      button.textContent = option;
      button.onclick = () => checkAnswer(button, idx);
      optionsContainer.appendChild(button);
    });
  
    // 문제마다 이미지 변경
    if (questions[index].imageUrl) {
      imageContainer.style.display = "block";
      changeImage(questions[index].imageUrl);
    } else {
      imageContainer.style.display = "none";
    }
  }
  
  function checkAnswer(button, selectedOption) {
    if (selectedOption === questions[currentQuestionIndex].correctOption) {
      button.style.backgroundColor = "lightgreen";
    } else {
      button.style.backgroundColor = "lightpink";
      
      currentQuestionIndex--;
    }
  
    // 일정 시간 후 문제를 풀도록 변경
    setTimeout(() => {
      currentQuestionIndex++;
      if (currentQuestionIndex < questions.length) {
        showQuestion(currentQuestionIndex);
      } else {
        Swal.fire({
            title: "퀴즈 완료!",
            text: "모든 퀴즈를 완료했습니다!",
            icon: "success",
            confirmButtonText: "수료증 보러 가기"
            }).then(() => {
                window.location.href = "/name"; // 메인 페이지 URL로 변경
            });
      }
    }, 1000);
  }


  
  showQuestion(currentQuestionIndex);

