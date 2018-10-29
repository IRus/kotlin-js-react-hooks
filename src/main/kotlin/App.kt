import kotlin.browser.document
import kotlin.browser.window

@JsModule("react")
external val React: dynamic

fun Hello(): Any {
    val (name, setName) = useState { "Ruslan" }


    useEffect({
        document.title = name

        window.setTimeout({
            setName("Kotlin")
        }, 1000)

        return@useEffect { println("Destroy") }
    }, arrayOf(name))

    return React.createElement("p", object {}, name)
}

typealias Dispatch<S> = (S) -> Unit

fun <S> useState(initialValue: () -> S): Pair<S, Dispatch<S>> {
    val arr = React.useState(initialValue)
    return Pair(arr[0] as S, arr[1] as Dispatch<S>)
}

fun useEffect(create: () -> Any, inputs: Array<Any>?) {
    React.useEffect({
        create()
    }, inputs)
}
