function App() {
    return (
        <div class='container mt-6'>
            <div className='row'>

                <div className='column'>
                    <h3>Token Generator</h3>
                    <hr/>
                    <div>
                        <button className="button button-outline">Generate Token</button>
                    </div>
                    <div>
                        <h2 className="">0091-2231-0310-1912</h2>
                    </div>
                </div>

                <div className='column'>
                    <h3>Validator</h3>
                    <hr/>
                    <div>
                        <input type="text"/>
                    </div>
                    <div>
                        <input className="button-primary button-outline" type="submit" value="validate"/>
                    </div>
                </div>


            </div>
        </div>
    );
}

export default App;
