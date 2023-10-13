import {TokenValidator} from "./component/validator/TokenValidator";
import {TokenGenerator} from "./component/generator/TokenGenerator";

function App() {

    return (
        <div class='container mt-6'>
            <div className='row'>
                <TokenGenerator/>
                <TokenValidator/>
            </div>
        </div>
    );
}

export default App;
