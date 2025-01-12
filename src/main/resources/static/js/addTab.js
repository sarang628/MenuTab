/**
 * @file leftMenu.html
 */
export function initializeMenu() {
    console.log("initializeMenu")
    // 메뉴 트리의 노드에서 a 태그에 data-tab-id가 있는 모든 항목 가져오기
    const menuLinks = document.querySelectorAll('.list-group-item a[data-tab-id]');

    console.log(menuLinks.length)

    menuLinks.forEach(link => {
        link.addEventListener('click', (event) => {
            event.preventDefault(); // 기본 동작(링크 이동) 방지
            const tabId = link.getAttribute('data-tab-id');
            const tabTitle = link.getAttribute('data-tab-title');
            const tabContent = link.getAttribute('data-tab-content');

            //addTab(tabId, tabTitle, tabContent);
            openOrActivateTab(tabId, tabTitle, tabContent);

        });
    });
}

/**
 * 동적으로 탭을 생성하고 활성화하는 함수
 *
 * @param {string} tabId - 생성될 탭의 고유 ID (HTML 요소의 id로 사용)
 * @param {string} tabTitle - 생성될 탭의 제목 (탭 버튼에 표시됨)
 * @param {string} [tabContent=""] - 생성될 탭의 콘텐츠 (탭 패널에 표시됨)
 * @returns {void} 반환값 없음
 */
function addTab(tabId, tabTitle, tabContent) {
    const tabList = document.getElementById('myTab'); // 탭 리스트
    const tabContentContainer = document.getElementById('myTabContent'); // 탭 콘텐츠 컨테이너

    // 새로운 탭 버튼 생성
    const newTab = document.createElement('li');
    newTab.className = 'nav-item';
    newTab.role = 'presentation';

    const newTabButton = document.createElement('button');
    newTabButton.className = 'nav-link';
    newTabButton.id = `${tabId}`;
    newTabButton.setAttribute('data-bs-toggle', 'tab');
    newTabButton.setAttribute('data-bs-target', `#${tabId}`);
    newTabButton.setAttribute('type', 'button');
    newTabButton.setAttribute('role', 'tab');
    newTabButton.setAttribute('aria-controls', tabId);
    newTabButton.setAttribute('aria-selected', 'false');
    newTabButton.textContent = tabTitle;

    // 닫기 버튼
    const closeButton = document.createElement('button');
    closeButton.type = 'button';
    closeButton.className = 'btn-close ms-2';
    closeButton.setAttribute('aria-label', 'Close');

    // 닫기 버튼 이벤트 추가
    closeButton.addEventListener('click', () => {
        const tabContent = document.querySelector(`#${tabId}`);
        if (tabContent) tabContent.remove(); // 탭 콘텐츠 삭제
        newTabButton.remove(); // 탭 버튼 삭제
    });

    // 탭 버튼에 추가
    newTabButton.appendChild(closeButton);
    newTab.appendChild(newTabButton);
    tabList.appendChild(newTab);

    // 새로운 탭 콘텐츠 생성
    const newTabPane = document.createElement('div');
    newTabPane.className = 'tab-pane fade';
    newTabPane.id = tabId;
    newTabPane.setAttribute('role', 'tabpanel');
    newTabPane.setAttribute('aria-labelledby', `${tabId}`);

    const tabHeading = document.createElement('h3');
    tabHeading.textContent = tabTitle;

    const tabParagraph = document.createElement('p');
    tabParagraph.textContent = tabContent;

    newTabPane.appendChild(tabHeading);
    newTabPane.appendChild(tabParagraph);
    tabContentContainer.appendChild(newTabPane);

    // 새로 추가된 탭을 활성화
    const tabTrigger = new bootstrap.Tab(newTabButton);
    tabTrigger.show();
}

/**
 * 메뉴 클릭 시 탭을 열거나 이미 열려 있는 경우 활성화하는 함수
 *
 * @param {string} tabId - 탭의 고유 ID (HTML 요소의 ID로 사용)
 * @param {string} tabTitle - 탭 제목 (버튼에 표시)
 * @param {string} tabContent - 탭 콘텐츠 (패널에 표시)
 */
function openOrActivateTab(tabId, tabTitle, tabContent) {
    // 기존 탭 버튼 찾기
    const existingTabButton = document.getElementById(`${tabId}`);

    if (existingTabButton) {
        // 이미 열려 있는 경우, 해당 탭을 활성화
        const tabTrigger = new bootstrap.Tab(existingTabButton);
        tabTrigger.show(); // Bootstrap API로 탭 활성화
        return; // 새 탭을 생성하지 않고 종료
    }

    // 열려 있지 않은 경우 새 탭 생성
    addTab(tabId, tabTitle, tabContent);
}