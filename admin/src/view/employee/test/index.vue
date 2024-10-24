<script setup lang="ts"></script>

<template>
  <div class="wrap">
    <div class="left">
      <ul class="status-left">
        <li class="">
          <span class="interface-icon has-hover"
            ><span class="interface-title">以太网 </span><span class="iconfont icon-lan"></span
          ></span>
          <div class="status-line is-left">
            <div
              class="sub-line is-off"
              style="right: 0px; border-left: none; height: 86.25px; top: 0px; border-bottom: none"></div>
          </div>
        </li>
        <li class="">
          <span class="interface-icon has-hover"
            ><span class="interface-title">中继 </span><span class="iconfont icon-wireless"></span>
          </span>
          <div class="status-line is-left">
            <div
              class="sub-line is-online"
              style="right: 0px; border-left: none; height: 28.75px; top: 0px; border-bottom: none"></div>
          </div>
        </li>
        <li class="is-active">
          <span class="interface-icon has-hover"
            ><span class="interface-title">热点共享 </span><span class="iconfont icon-tethering"></span>
          </span>
          <div class="status-line is-left">
            <div
              class="sub-line is-off"
              style="right: 0px; border-left: none; height: 28.75px; border-top: none; bottom: 0px"></div>
            <div
              class="center-line is-online"
              style="
                right: 0px;
                border-right: none;
                border-left: none;
                transform: translateX(calc(100% - 0.5px));
                height: 28.75px;
                border-bottom: none;
                bottom: 0px;
              "></div>
          </div>
        </li>
        <li class="">
          <span class="interface-icon has-hover"
            ><span class="interface-title">蜂窝网络 </span><span class="iconfont icon-modem"></span>
          </span>
          <div class="status-line is-left">
            <div
              class="sub-line is-off"
              style="right: 0px; border-left: none; height: 86.25px; border-top: none; bottom: 0px"></div>
          </div>
        </li>
      </ul>
    </div>
    <div class="router-info">
      <div id="mt3000" class="typeof-router">
        <div class="svg-container">
          <svg
            version="1.1"
            id="Layer_1"
            xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink"
            x="0px"
            y="0px"
            fill="#fff"
            viewBox="0 0 200 200"
            style="enable-background: new 0 0 200 200"
            xml:space="preserve">
            <g>
              <path
                d="M18,151.1c-7.4-0.8-8-7.5-8-9.5c0-2.4-0.2-4.2-0.2-4.2L8.7,66.9c0-0.2,0.5-13.6,10.3-15c3.3-0.5,6,0.1,8.1,1.8
		c3.3,2.6,3.8,7,3.9,8.3c0.2,2.9,0.8,55.2,0.8,57.5l-1.3,0c0-0.5-0.6-54.5-0.8-57.4c-0.1-0.8-0.5-5-3.4-7.4
		c-1.8-1.4-4.2-1.9-7.1-1.5C10.5,54.5,10,66.8,10,66.9l1.2,70.4c0,0,0.2,1.7,0.2,4.3c0,2.2,0.7,7.5,6.8,8.2L18,151.1z"></path>
              <path
                d="M131.9,175.3c-2.5,0-5.4-0.2-8.4-0.7c-7.5-1.3-67.6-9.3-85.8-11.7c-6.1-0.8-11.5-3.3-15.7-7.1c-5-4.6-7.2-9.7-6.5-15.3
		c1.8-14.2,8.6-21.9,20.2-22.9l31-6.6c0.2-0.1,7.2-2.9,20-1.6c7.7,0.8,34.9,3.4,56.4,5.3l-0.1,1.3c-21.5-2-48.8-4.5-56.5-5.3
		c-12.5-1.3-19.4,1.5-19.5,1.5L35.8,119c-11.1,0.9-17.3,8.1-19.1,21.7c-0.6,5.1,1.4,9.9,6.1,14.2c4,3.7,9.2,6,15,6.8
		c18.2,2.4,78.3,10.4,85.8,11.7c8.7,1.5,16.4,0,16.4,0c0.2-0.1,31.6-11.5,41-15.1c9.6-3.7,12.3-17.6,8.7-27.7
		c-3.7-10.5-16.4-11.6-16.5-11.6c-0.1,0-7.1-0.8-10.9-1.2l0.1-1.3c3.9,0.4,10.9,1.2,10.9,1.2c0.1,0,13.6,1.1,17.6,12.5
		c3.7,10.7,0.8,25.4-9.5,29.3c-9.4,3.6-40.8,15-41.1,15.1C140.2,174.7,136.8,175.3,131.9,175.3z"></path>
              <path
                d="M15.3,150c0-0.7-2.6-73.4-2.2-83.7C13.5,55.6,21,52,21.3,51.8l0.6,1.2c-0.3,0.1-7.1,3.4-7.4,13.3
		c-0.4,10.3,2.2,82.9,2.2,83.6L15.3,150z"></path>
              <path
                d="M151.7,168.2c-2,0-4.2-0.4-5.9-2c-2.4-2.1-3.5-5.9-3.5-11.6c0-4.7,0-7.4,0.1-8.9h-0.1l0-78.6c0-0.1,0-3.4,2.5-5.9
		c1.8-1.8,4.4-2.7,7.8-2.7c9.7,0,10.3,8.7,10.3,8.8v82.5c-0.1,3.8-0.6,7.5-1.7,10.8c-1.5,4.8-3.2,7.1-5.2,7.2
		c-0.4,0-0.9,0.1-1.4,0.1C153.7,168.1,152.8,168.2,151.7,168.2z M143.6,145.7c0,1.4,0,4.1,0,8.9c0,5.2,1,8.8,3.1,10.6
		c2.2,2,5.3,1.7,7.8,1.5c0.5-0.1,1-0.1,1.5-0.1c1.3-0.1,2.8-2.4,4-6.3c1-3.2,1.6-6.7,1.6-10.4V67.3c0-0.3-0.5-7.4-9-7.5
		c0,0-0.1,0-0.1,0c-8.8,0-8.9,7-8.9,7.3L143.6,145.7C143.6,145.7,143.6,145.7,143.6,145.7L143.6,145.7z"></path>
              <path
                d="M151,168c-5.8-3.6-4.7-13.5-4.7-13.9c0-0.6,0.4-67,0-78.5l-0.1-8.7c0-0.2-0.1-4.4,2.2-6.8c1.1-1.1,2.5-1.7,4.2-1.7v1.3
		c-1.3,0-2.4,0.4-3.2,1.3c-2,2-1.8,5.8-1.8,5.9l0.1,8.7c0.4,11.5,0,77.9,0,78.6c0,0.2-1.1,9.5,4.1,12.7L151,168z"></path>
              <path
                d="M77,152.1c-0.6,0-1.1-0.1-1.1-0.1l0,0c0,0-3.6-0.3-8.4-0.9c-5.2-0.6-5.2-3.2-5.2-3.3v-0.5l19.4,2.4l-0.3,0.6
		C80.3,151.8,78.3,152.1,77,152.1z M63.3,148.3c0.4,0.6,1.4,1.6,4.3,1.9c4.8,0.6,8.4,0.9,8.4,0.9c0.1,0,2.7,0.4,4.1-0.8L63.3,148.3z
		"></path>
              <rect
                x="39.1"
                y="121.8"
                transform="matrix(0.1246 -0.9922 0.9922 0.1246 -109.7423 166.2441)"
                width="0.4"
                height="47"></rect>
              <polygon points="142.9,159.2 80.2,151 80.2,150.6 143,158.8 	"></polygon>
              <path
                d="M162.7,134.5l-0.3-1.3l20.2-5.1c2.1-0.5,7.1-1.4,7.9,0.5l-1.2,0.6c-0.2-0.5-3.1-0.5-6.4,0.2L162.7,134.5z"></path>
              <rect
                x="158.3"
                y="158.4"
                transform="matrix(0.942 -0.3357 0.3357 0.942 -43.336 67.4384)"
                width="30.3"
                height="1.3"></rect>
              <path
                d="M161.1,161l-0.1-0.4l21.2-7c3.8-1.3,6.6-4.5,7.4-8.4c0.7-3.9,0.2-7.9-0.1-10.5c0-0.4-0.1-0.7-0.1-1c-0.1-1-0.5-1.8-1.2-2.3
		c-1.5-1.1-3.8-0.6-3.8-0.6l-21.8,5.5l-0.1-0.4l21.8-5.5c0.1,0,2.5-0.5,4.2,0.7c0.8,0.6,1.3,1.5,1.4,2.6c0,0.3,0.1,0.6,0.1,1
		c0.3,2.7,0.9,6.7,0.1,10.7c-0.8,4.1-3.7,7.4-7.7,8.7L161.1,161z"></path>
              <path d="M164.2,158.3v-20.7l1.7-0.6v20.5L164.2,158.3z M164.6,138v19.7l0.9-0.4v-19.6L164.6,138z"></path>
              <path d="M167,157.6V137l1.7-0.6v20.5L167,157.6z M167.4,137.3V157l0.9-0.4V137L167.4,137.3z"></path>
              <path d="M169.5,156.9v-20.7l1.7-0.6v20.5L169.5,156.9z M170,136.6v19.7l0.9-0.4v-19.6L170,136.6z"></path>
              <path d="M172,156.1v-20.7l1.7-0.6v20.5L172,156.1z M172.4,135.8v19.7l0.9-0.4v-19.6L172.4,135.8z"></path>
              <path
                d="M174.5,155.2v-20.6l1.7-0.6v20.4L174.5,155.2z M174.9,134.9v19.6l0.9-0.4v-19.5L174.9,134.9z"></path>
              <path d="M176.7,154.2V134l1.7-0.6v20L176.7,154.2z M177.1,134.3v19.2l0.9-0.4V134L177.1,134.3z"></path>
              <path d="M179,153.4v-20.1l1.7-0.6v19.9L179,153.4z M179.4,133.6v19.1l0.9-0.4v-19L179.4,133.6z"></path>
              <path d="M181.2,152.5v-19.7l1.7-0.6v19.5L181.2,152.5z M181.6,133v18.8l0.9-0.4v-18.7L181.6,133z"></path>
              <path d="M183.4,151.8V132l1.7-0.6V151L183.4,151.8z M183.8,132.3v18.8l0.9-0.4V132L183.8,132.3z"></path>
              <path
                d="M185.7,149.9v-17.5l1.7-0.5v17.3L185.7,149.9z M186.2,132.8v16.5l0.9-0.3v-16.4L186.2,132.8z"></path>
            </g>
          </svg>
        </div>
      </div>
      <div class="alias"><span> GL-MT3000 </span></div>
      <ul class="app-list">
        <li class="is-active"><span class="iconfont icon-ipv6"></span>IPv6</li>
      </ul>
      <ul class="wifi-list">
        <li class="el-tooltip is-active" tabindex="-1">
          <span class="iconfont icon-wifi-5g">1</span>
        </li>
        <li class="el-tooltip is-active" tabindex="-1">
          <span class="iconfont icon-wifi-2g">2</span>
        </li>
        <li class="el-tooltip is-active" tabindex="-1">
          <span class="iconfont icon-guest-wifi-5g">3</span>
        </li>
        <li class="el-tooltip" tabindex="-1">
          <span class="iconfont icon-guest-wifi-2g">4</span>
        </li>
      </ul>
    </div>
    <div class="right">
      <ul class="status-right">
        <li class="">
          <div class="status-line is-right">
            <div
              class="sub-line is-off"
              style="left: 0px; border-right: none; height: 57.5px; top: 0px; border-bottom: none"></div>
          </div>
          <span class="client-icon"
            ><span class="iconfont icon-wlan-client"></span><span class="count">0</span
            ><span class="client-label">无线客户端</span></span
          >
        </li>
        <li class="is-active">
          <div class="status-line is-right">
            <div
              class="sub-line is-online"
              style="left: 0px; border-right: none; height: 57.5px; border-top: none; bottom: 0px"></div>
            <div
              class="center-line is-online"
              style="
                left: 0px;
                border-right: none;
                border-left: none;
                transform: translateX(calc(-100% + 0.5px));
                height: 57.5px;
                border-bottom: none;
                bottom: 0px;
              "></div>
          </div>
          <span class="client-icon"
            ><span class="iconfont icon-lan-client"></span><span class="count">1</span
            ><span class="client-label">LAN客户端</span></span
          >
        </li>
      </ul>
    </div>
  </div>
</template>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  word-wrap: break-word;
  word-break: normal;
}

.wrap {
  display: flex;
  position: relative;
  max-width: 1075px;
  //margin: 0 -20px;
  //width: calc(100% + 40px);
  height: 362px;
  background: radial-gradient(circle, rgba(5, 2, 47, 1) 28%, rgba(55, 41, 152, 1) 86%, rgba(54, 40, 151, 1) 110%);
  display: flex;
  align-items: center;
  justify-content: center;
  color: #9195aa;

  .left {
    color: inherit;
    display: flex;
    align-items: center;
    height: 100%;
    padding: 66px 0;
    margin-right: 62px;
    position: relative;

    .status-left {
      flex: 1;
      height: 100%;
      display: flex;
      flex-direction: column;
      align-items: flex-end;
      justify-content: space-around;

      li {
        color: inherit;
        display: flex;
        justify-content: center;
        align-items: center;

        .is-left {
          margin-left: 10px;
        }
      }

      .is-active {
        color: #4bd9cc;
      }
    }
  }

  .router-info {
    color: inherit;
    padding-top: 40px;
    padding-bottom: 30px;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;

    .typeof-router .svg-container {
      width: 135px;
      height: 135px;
    }

    .alias {
      margin: 0 4px 18px;
      font-size: 14px;
      color: #9195aa;
    }

    .app-list {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-bottom: 18px;
      min-height: 50px;
      min-width: 150px;
    }

    .wifi-list {
      height: 45px;
      background: rgba(120, 122, 147, 0.24);
      border-radius: 5px;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 0 5px;
      cursor: pointer;
    }
  }

  .right {
    color: inherit;
    display: flex;
    align-items: center;
    padding: 66px 0;
    height: 100%;
    margin-left: 62px;
    position: relative;

    .status-right {
      flex: 1;
      height: 100%;
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      justify-content: space-around;

      li {
        color: inherit;
        display: flex;
        justify-content: center;
        align-items: center;

        .is-right {
          margin-right: 10px;
        }

        .client-icon {
          cursor: pointer;
          display: flex;
          justify-content: flex-start;
          align-items: center;
          margin-left: 8px;

          .count {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 2px 6px;
            margin: 0 10px;
            border: 1px solid;
            border-radius: 20px;
          }
        }
      }

      .is-active {
        color: #4bd9cc;
      }
    }
  }
}

.status-line {
  width: 58px;
  height: 0;
  position: relative;
  border: none;

  .sub-line.is-off {
    border-style: dashed;
    border-color: #9195aa;
    z-index: 1;
  }

  .sub-line.is-online {
    border-style: solid;
    border-color: #9195aa;
    z-index: 3;
  }

  .center-line {
    position: absolute;
    width: 58px;
    border: none;
    border-top: 1px solid #9195aa;
  }

  .sub-line {
    width: 58px;
    position: absolute;
    border: 1px dashed #9195aa;
  }
}
</style>
