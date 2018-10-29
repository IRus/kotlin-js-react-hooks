import * as React from "react";
import * as ReactDOM from "react-dom";
import {Hello} from "./build/classes/kotlin/main/react-hooks"

ReactDOM.render(
    React.createElement(Hello, {}),
    document.getElementById("root")
);

